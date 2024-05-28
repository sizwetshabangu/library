import { UUID } from "crypto";
import { Column, Entity, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class Book {
    @PrimaryGeneratedColumn('uuid')
    id: UUID;
    @Column('varchar')
    isbn: string;
    @Column()
    category: string;
    @Column()
    title: string;
    @Column()
    author: string;
    @Column()
    language: string;
    @Column()
    publicationYear: number;
    @Column()
    publisher: string;
    @Column()
    image: string;
    @Column()
    isAvailable: boolean;
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
    updatedBy: UUID;
    @Column()
    createdBy: UUID;
    constructor() { }
}
