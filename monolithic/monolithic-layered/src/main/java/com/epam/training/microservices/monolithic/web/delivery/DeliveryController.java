package com.epam.training.microservices.monolithic.web.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.service.CrudService;
import com.epam.training.microservices.monolithic.service.delivery.DeliveryService;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllSupport;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.all.column.LinkColumnModel;
import com.epam.training.microservices.monolithic.web.crud.all.column.TextColumnModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController implements ViewAllSupport<Delivery> {

  private final DeliveryService deliveryService;
  private final DeliveryTransformer deliveryTransformer;

  @Override
  public CrudService<Delivery> getService() {
    return deliveryService;
  }

  @Override
  public ViewAllTemplateParams<Delivery> getViewAllTemplateParams() {
    return ViewAllTemplateParams.<Delivery>builder()
        .title("Delivery")
        .column(new LinkColumnModel<>("Address", Delivery::getAddressLine,
            d -> "/com.epam.training.service.delivery/" + d.getId()))
        .column(new TextColumnModel<>("Status", d -> d.getStatus().name()))
        .build();
  }

  @GetMapping("/{id}")
  public ModelAndView editDelivery(ModelAndView modelAndView, @PathVariable("id") Long id) {
    modelAndView.setViewName("delivery/edit");
    modelAndView.addObject("delivery", deliveryTransformer.toModel(id));

    return modelAndView;
  }
}