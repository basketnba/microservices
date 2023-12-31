package com.epam.training.microservices.monolithic.web;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.service.CrudService;
import com.epam.training.microservices.monolithic.service.disease.DiseaseService;
import com.epam.training.microservices.monolithic.web.crud.CrudController;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.all.column.LinkColumnModel;
import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.single.form.HiddenFieldModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.TextFieldModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/diseases")
public class DiseaseController implements CrudController<Disease> {

  private final DiseaseService diseaseService;

  @Override
  public ViewAllTemplateParams<Disease> getViewAllTemplateParams() {
    return ViewAllTemplateParams.<Disease>builder()
        .title("Diseases")
        .column(new LinkColumnModel<>("Name", Disease::getName,
            disease -> "/diseases/" + disease.getId()))
        .build();
  }

  @Override
  public ViewSingleTemplateParams<Disease> getViewSingleTemplateParams() {
    return ViewSingleTemplateParams.<Disease>builder()
        .title("Edit disease")
        .field(new HiddenFieldModel<>("id", "id"))
        .field(new TextFieldModel<>("Name", "name"))
        .build();
  }

  @Override
  public CrudService<Disease> getService() {
    return diseaseService;
  }
}