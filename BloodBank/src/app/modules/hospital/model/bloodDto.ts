
export class BloodDTO {
    id: number;
    quantity: string;
    bloodType: string;

    public constructor(
        id: number = 0,
        quantity: string = '',
        bloodType: string = '',
    ) {
        this.id = id;
        this.quantity = quantity;
        this.bloodType = bloodType;
    }
}