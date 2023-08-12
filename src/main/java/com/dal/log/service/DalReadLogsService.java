package com.dal.log.service;

import java.io.IOException;

import com.dal.log.dto.DalLogDto;

public interface DalReadLogsService {
	DalLogDto getLogs(Long reqLines) throws IOException;
}
