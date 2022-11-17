import { Address } from "./address";
import { Role } from "./role";

export class Person {
    id: number = 0;
    name: string = '';
    surname: string = '';
    email: string = '';
    password: string = '';
    phonNumber: string = '';
    jmbg: string = '';
    gender: string = '';
    role: Role = 0;
    dateOfBirth: Date;
    occupation: string='';
    informationAboutCompany: string = '';
    bloodType: string = '';
    address: Address;

    public constructor(obj?: any ) {
        this.id = obj.id;
        this.dateOfBirth = obj.dateOfBirth;
        this.address = obj.address;        
        this.name = obj.name;
        this.surname = obj.surname;
        this.email = obj.email;
        this.password = obj.password;
        this.phonNumber = obj.phonNumber;
        this.jmbg = obj.jmbg;
        this.gender = obj.gender;
        this.role = obj.role;
        this.occupation = obj.occupation;
        this.informationAboutCompany = obj.informationAboutCompany;
        this.bloodType = obj.bloodType;
    }
}