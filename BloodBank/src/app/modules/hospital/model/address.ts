export class Address {
    id: number = 0;
    deleted: boolean = false;
    latitude: number=0;
    longitude: number=0;
    street: string = '';
    number: string = '';
    city: string = '';
    country: string = '';

    public constructor(id: any, latitude: any, longitude: any, street: any, number:any, city: any, country:any ) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
    }
}