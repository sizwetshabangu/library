import { UUID } from "crypto";
import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class Category {
    @PrimaryGeneratedColumn('uuid')
    id: UUID;
    @Column('varchar', { length: 100, nullable: false })
    name: string;
    @Column('varchar')
    description: string;
    @Column('datetime')
    createdAt: Date;
    @Column('datetime', { nullable: true })
    updatedAt: Date;
    @Column('datetime', { nullable: true })
    deletedAt: Date;
    @Column('boolean', { default: false, nullable: false })
    deleted: boolean;
    @Column('varchar', { nullable: true })
    deletedBy: string;
    @Column('varchar', { nullable: true })
    updatedBy: string;
    @Column('varchar', { nullable: false })
    createdBy: string;
    constructor() { }
}
