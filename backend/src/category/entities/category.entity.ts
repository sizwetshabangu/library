import { UUID } from "crypto";
import { Column, Entity, ManyToOne, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class Category {
    @PrimaryGeneratedColumn('uuid')
    id: UUID;
    @Column('varchar', { length: 100, nullable: false })
    name: string;
    @Column('varchar')
    description: string;
    @Column('datetime', { default: () => 'CURRENT_TIMESTAMP' })
    createdAt: Date;
    @Column('datetime', { nullable: true })
    updatedAt: Date;
    @Column('datetime', { nullable: true })
    deletedAt: Date;
    @Column('boolean', { default: false, nullable: false })
    deleted: boolean;
    @Column('uuid', { nullable: true })
    deletedBy: string;
    @Column('uuid', { nullable: true })
    updatedBy: string;
    @Column('uuid', { nullable: true })
    createdBy: string;
    constructor() { }
}
