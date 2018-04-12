import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { routerTransition } from '../../../router.animations';
import { EquipmentModelsService } from '../equipment-models.service';
import { EquipmentTypesService } from '../../equipment-types/equipment-types.service';
import { EquipmentType } from '../../models/equipment-type.model';

@Component({
  selector: 'app-equipment-model',
  templateUrl: './equipment-model.component.html',
  animations: [routerTransition()]
})
export class EquipmentModelComponent implements OnInit {

  form: FormGroup
  title: string
  equipmentTypes: EquipmentType[]

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private equipmentModelsService: EquipmentModelsService,
    private equipmentTypesService: EquipmentTypesService
  ) { }

  ngOnInit() {
    this.equipmentTypesService.getItems().subscribe(
      equipmentTypes => this.equipmentTypes = equipmentTypes);

    this.form = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      description: [],
      rate: ['', Validators.required],
      equipmentTypeId: ['', Validators.required]
    });

    var id = this.route.params.subscribe(params => {
      var id = params['id'];
      this.title = id ? 'Editar ' : 'Novo ';

      if (!id)
        return;

      this.equipmentModelsService.getItem(id).subscribe(
        equipmentModel => this.form.patchValue(equipmentModel),
        response => {
          if (response.status == 404) {
            this.router.navigate(['not-found']);
          }
        });
    });
  }

  save() {
    var result, equipmentModel = this.form.value;

    if (equipmentModel.id) {
      result = this.equipmentModelsService.updateItem(equipmentModel);
    } else {
      result = this.equipmentModelsService.addItem(equipmentModel);
    }

    result.subscribe(data => this.router.navigate(['equipment-models']));
  }

}