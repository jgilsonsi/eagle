import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { routerTransition } from '../../../router.animations';
import { EquipmentTypesService } from '../equipment-types.service';

@Component({
  selector: 'app-equipment-type',
  templateUrl: './equipment-type.component.html',
  animations: [routerTransition()]
})
export class EquipmentTypeComponent implements OnInit {

  form: FormGroup
  title: string

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private equipmentTypesService: EquipmentTypesService
  ) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      id: [],
      name: ['', Validators.required]
    });

    var id = this.route.params.subscribe(params => {
      var id = params['id'];
      this.title = id ? 'Editar ' : 'Novo ';

      if (!id)
        return;

      this.equipmentTypesService.getItem(id).subscribe(
        equipmentType => this.form.patchValue(equipmentType),
        response => {
          if (response.status == 404) {
            this.router.navigate(['not-found']);
          }
        });
    });
  }

  save() {
    var result, equipmentType = this.form.value;

    if (equipmentType.id) {
      result = this.equipmentTypesService.updateItem(equipmentType);
    } else {
      result = this.equipmentTypesService.addItem(equipmentType);
    }

    result.subscribe(data => this.router.navigate(['equipment-types']));
  }

}