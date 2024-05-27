import { UUID } from "crypto";

export class Address {
    constructor(
        private id: UUID,
        private houseNumber: number,
        private street: string,
        private city: string,
        private province: string,
        private country: string,
        private postalCode: string,
        private createdAt: Date,
        private updatedAt: Date,
    ) { }
}
