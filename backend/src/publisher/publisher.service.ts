import { Inject, Injectable } from '@nestjs/common';
import { CreatePublisherDto } from './dto/create-publisher.dto';
import { UpdatePublisherDto } from './dto/update-publisher.dto';
import { UUID } from 'crypto';
import { PUBLISHER_REPOSITORY } from 'src/shared/constants';
import { Repository } from 'typeorm';
import { Publisher } from './entities/publisher.entity';

@Injectable()
export class PublisherService {
  constructor(@Inject(PUBLISHER_REPOSITORY) private publisherRepository: Repository<Publisher>) { }
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
