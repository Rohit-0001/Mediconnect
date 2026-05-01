import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { MediConnectRoutingModule } from "./mediconnect-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { PatientCreateComponent } from "./components/patientcreate/patientcreate.component";
import { DoctorCreateComponent } from "./components/doctorcreate/doctorcreate.component";
import { ClinicCreateComponent } from "./components/cliniccreate/cliniccreate.component";

@NgModule({
  declarations: [
    PatientCreateComponent,
    DoctorCreateComponent,
    ClinicCreateComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  exports: [
    PatientCreateComponent,
    DoctorCreateComponent,
    ClinicCreateComponent
  ]
})
export class MediconnectModule {}
