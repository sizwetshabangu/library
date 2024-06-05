import { Injectable } from '@nestjs/common';
import { CreatePublisherDto } from './dto/create-publisher.dto';
import { UpdatePublisherDto } from './dto/update-publisher.dto';
import { UUID } from 'crypto';
import { Repository } from 'typeorm';
import { Publisher } from './entities/publisher.entity';
import { InjectRepository } from '@nestjs/typeorm';

@Injectable()
export class PublisherService {
  constructor(@InjectRepository(Publisher) private publisherRepository: Repository<Publisher>) { }
  create(createPublisherDto: CreatePublisherDto) {
    return this.publisherRepository.save(createPublisherDto);
  }

  findAll() {
    return this.publisherRepository.find();
  }

  findOne(id: UUID) {
    return this.publisherRepository.findOneBy({ id });
  }

  update(id: UUID, updatePublisherDto: UpdatePublisherDto) {
    return this.publisherRepository.update(id, updatePublisherDto);
  }

  remove(id: UUID) {
    return this.publisherRepository.delete(id);
  }
}
