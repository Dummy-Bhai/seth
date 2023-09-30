import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  r: any={id:'',name:'',gender:'',city:'',phone:'',email:'',address:'',A:'false',B:'false',C:'false'};
 

  constructor() {
  }

  onRegister(){
    console.log("Shaikh Nadim KSBSCIT058");
    console.log("ID:",this.r.id);
    console.log("NAME:",this.r.name);
    console.log("GENDER:",this.r.gender);
    console.log("CITY:",this.r.city);
    console.log("PHONE NUMBER:",this.r.phone);
    console.log("EMAIL:",this.r.email);
    console.log("ADDRESS:",this.r.address);
    if(this.r.A==true){
      console.log("A",this.r.A);
    }
    if(this.r.B==true){
      console.log("B",this.r.B);
    }
    if(this.r.C==true){
      console.log("C",this.r.C);
    }
  }
}
