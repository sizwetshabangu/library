import { ReaderDto } from "./reader.dto";

export type CreateReaderDto = Omit<ReaderDto, 'createdBy' | 'updatedBy' | 'createdAt' | 'updatedAt' | 'deletedAt'> 
