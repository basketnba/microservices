package com.epam.training.microservices.monolithic.web.crud.single;

import com.epam.training.microservices.monolithic.web.crud.CrudSupport;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

public interface ViewSingleSupport<T> extends CrudSupport<T> {

  ViewSingleTemplateParams<T> getViewSingleTemplateParams();

  @GetMapping("/{id}")
  default ModelAndView viewSingle(ModelAndView modelAndView, @PathVariable("id") Long id) {
    final ViewSingleTemplateParams<T> templateParams = getViewSingleTemplateParams();

    modelAndView.setViewName(templateParams.getViewName());
    modelAndView.addObject("pageTitle", templateParams.getTitle());
    modelAndView.addObject("item", getService().findOne(id).orElseThrow(() -> {
      return new RuntimeException("No item with id " + id);
    }));
    modelAndView.addObject("submitTarget", getSubmitTarget());
    modelAndView.addObject("templateParams", templateParams);
    return modelAndView;
  }

  @PostMapping("")
  default String saveSingle(@ModelAttribute T item) {
    getService().save(item);
    return "redirect:" + getSubmitTarget();
  }

  default String getSubmitTarget() {
    return Optional.ofNullable(this.getClass().getDeclaredAnnotation(RequestMapping.class))
        .map(RequestMapping::value)
        .map(values -> values[0])
        .orElseThrow(() -> new RuntimeException("No RequestMapping annotation"));
  }
}