import { UUID } from "crypto";
import { PrimaryGeneratedColumn, Entity, Column } from "typeorm";

@Entity()
export class Address {
    @PrimaryGeneratedColumn('uuid')
    id: UUID;
    @Column('int')
    houseNumber: number;
    @Column('varchar', { length: 255, nullable: false, })
    street: string;
    @Column('varchar', { length: 255, nullable: false, })
    city: string;
    @Column('varchar')
    province: string;
    @Column('varchar')
    country: string;
    @Column('int')
    postalCode: string;
    @Column('datetime')
    createdAt: Date;
    @Column('datetime')
    updatedAt: Date;
    constructor() {

    }
}
