import { Address } from './address';

export class AdminDTO{
    name: String;
	surname: String;
	email: String;
	password: String;
	phonNumber: String;
	jmbg: String;
	gender: String;
	occupation: String;
	informationAboutCompany: String;
	dateOfBirth: Date;
	bloodType: String;
	address: Address;


    public constructor(
        name: String = '',
        surname: String = '',
        email: String = '',
        password: String = '',
        phonNumber: String = '',
        jmbg: String = '',
        gender: String = '',
        occupation: String = '',
        informationAboutCompany: String = '',
        dateOfBirth: Date = new Date(),
        bloodType: String = '',
        address: Address = new Address(),
    ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phonNumber = phonNumber;
        this.jmbg = jmbg;
        this.gender = gender;
        this.occupation = occupation;
        this.informationAboutCompany = informationAboutCompany;
        this.dateOfBirth = dateOfBirth;
        this.bloodType = bloodType;
        this.address = address;
    }
}