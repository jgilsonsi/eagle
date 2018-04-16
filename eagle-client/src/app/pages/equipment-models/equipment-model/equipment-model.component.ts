import { Component, OnInit, ViewChild } from '@angular/core';
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
  equipmentModelImage: any;
  isImagePresent: boolean = false;

  @ViewChild("fileInput") fileInput;

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
        res => {
          if (res.status == 404) {
            this.router.navigate(['not-found']);
          }
        });

      this.equipmentModelsService.getImage(id).subscribe(
        data => {
          this.createImageFromBlob(data);
          this.isImagePresent = true;
          console.log("presente");
        }, error => {
          this.isImagePresent = false;
          console.log("não presente");
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

  createImageFromBlob(image: Blob) {
    let reader = new FileReader();
    reader.addEventListener("load", () => {
      this.equipmentModelImage = reader.result;
    }, false);

    if (image) {
      reader.readAsDataURL(image);
    }
  }

  addFile() {
    console.log("subindo arquivo...")
    let fi = this.fileInput.nativeElement;
    if (fi.files && fi.files[0]) {
      let fileToUpload = fi.files[0];
      /* this.uploadService
         .upload(fileToUpload)
         .subscribe(res => {
           console.log(res);
         });*/
    }
  }
}