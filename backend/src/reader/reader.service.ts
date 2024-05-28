import { Inject, Injectable, Logger } from '@nestjs/common';
import { CreateReaderDto } from './dto/create-reader.dto';
import { UpdateReaderDto } from './dto/update-reader.dto';
import { READER_REPOSITORY } from 'src/common/constants';
import { Repository } from 'typeorm';
import { Reader } from './entities/reader.entity';
import { UUID } from 'crypto';

@Injectable()
export class ReaderService {
  constructor(@Inject(READER_REPOSITORY) private readerRepository: Repository<Reader>, private Logger: Logger) { }
  create(createReaderDto: CreateReaderDto) {
    return this.readerRepository.save(createReaderDto);
  }

  findAll() {
    return this.readerRepository.find();
  }

  findOne(id: UUID) {
    return this.readerRepository.findOneBy({ id });
  }

  update(id: UUID, updateReaderDto: UpdateReaderDto) {
    return this.readerRepository.update(id, updateReaderDto);
  }

  remove(id: UUID) {
    return this.readerRepository.delete(id);
  }
}
