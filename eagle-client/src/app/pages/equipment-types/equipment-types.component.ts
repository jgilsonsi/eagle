import { Component, OnInit } from '@angular/core';

import { routerTransition } from '../../router.animations';
import { EquipmentTypesService } from './equipment-types.service';
import { EquipmentType } from './../models/equipment-type.model';

@Component({
  selector: 'app-equipment-types',
  templateUrl: './equipment-types.component.html',
  animations: [routerTransition()]
})
export class EquipmentTypesComponent implements OnInit {

  equipmentTypes: EquipmentType[]

  constructor(private equipmentTypesService: EquipmentTypesService) { }

  ngOnInit() {
    this.equipmentTypesService.getItems().subscribe(
      equipmentTypes => this.equipmentTypes = equipmentTypes);
  }

  deleteItem(item) {
    if (confirm("Deseja realmente excluir o item: " + item.name + "?")) {
      var index = this.equipmentTypes.indexOf(item);
      this.equipmentTypes.splice(index, 1);

      this.equipmentTypesService.deleteItem(item.id)
        .subscribe(null,
          err => {
            alert("Não foi possível deletar o usuário.");
            // Revert the view back to its original state
            this.equipmentTypes.splice(index, 0, item);
          });
    }
  }

}
