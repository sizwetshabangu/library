import { UUID } from "crypto";
import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class Staff {
    @PrimaryGeneratedColumn('uuid')
    id: UUID;
    @Column('varchar')
    firstName: string;
    @Column('varchar')
    lastName: string;
    @Column('varchar')
    email: string;
    @Column('varchar')
    phone: string;
    @Column('varchar')
    address: string;
    @Column('datetime')
    createdAt: Date;
    @Column('datetime')
    updatedAt: Date;
    @Column('datetime')
    deletedAt: Date;
    @Column('boolean')
    deleted: boolean;
    @Column('uuid')
    deletedBy: string;
    @Column('uuid')
    updatedBy: string;
    @Column('uuid')
    createdBy: string;
    constructor() { }
}
