import { UUID } from "crypto";
import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class Reader {
    @PrimaryGeneratedColumn('uuid')
    id: UUID;
    @Column()
    firstName: string;
    @Column()
    lastName: string;
    @Column()
    email: string;
    @Column()
    phone: string;
    @Column()
    address: string;
    @Column()
    createdAt: Date;
    @Column()
    updatedAt: Date;
    @Column()
    deletedAt: Date;
    @Column()
    deleted: boolean;
    @Column()
    deletedBy: string;
    @Column()
    createdBy: string;
    @Column()
    updatedBy: string;
    constructor() { }
}
