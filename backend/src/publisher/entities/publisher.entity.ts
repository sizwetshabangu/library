import { UUID } from "crypto";
import { Column, Entity, PrimaryGeneratedColumn } from "typeorm"

@Entity()
export class Publisher {
    @PrimaryGeneratedColumn('uuid')
    id: UUID;
    @Column()
    name: string;
    @Column('datetime', { nullable: false, })
    createdAt: Date;
    @Column('datetime', { nullable: true, })
    updatedAt: Date;
    @Column('datetime', { nullable: true, })
    deletedAt: Date;
    @Column()
    deleted: boolean;
    @Column('uuid', { nullable: true, })
    deletedBy: string;
    @Column('uuid', { nullable: true, })
    updatedBy: string;
    @Column()
    createdBy: string;
    constructor() { }
}
