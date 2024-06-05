import { Logger, Module } from '@nestjs/common';
import { ReaderService } from './reader.service';
import { ReaderController } from './reader.controller';
import { Reader } from './entities/reader.entity';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [TypeOrmModule.forFeature([Reader])],
  controllers: [ReaderController],
  providers: [ReaderService, Logger],
})
export class ReaderModule { }
