import { UUID } from "crypto";
import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class Category {
    @PrimaryGeneratedColumn('uuid')
    id: UUID;
    @Column()
    name: string;
    @Column()
    description: string;
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
    updatedBy: string;
    @Column()
    createdBy: string;
    constructor() { }
}
