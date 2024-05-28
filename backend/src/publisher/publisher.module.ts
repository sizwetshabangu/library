import { Logger, Module } from '@nestjs/common';
import { PublisherService } from './publisher.service';
import { PublisherController } from './publisher.controller';
import { publisherRepository } from './publisher.provider';
import { DatabaseModule } from 'src/provider/database/database.module';

@Module({
  imports: [DatabaseModule],
  controllers: [PublisherController],
  providers: [...publisherRepository, PublisherService, Logger],
})
export class PublisherModule { }
