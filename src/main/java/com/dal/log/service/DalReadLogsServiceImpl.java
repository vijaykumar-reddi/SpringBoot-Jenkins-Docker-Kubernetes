package com.dal.log.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dal.log.dto.DalLogDto;

@Service
public class DalReadLogsServiceImpl implements DalReadLogsService {
	private static final Logger logger = LoggerFactory.getLogger(DalReadLogsServiceImpl.class);

	private final long defaultNoOfLogLines = 50;

	@Override
	public DalLogDto getLogs(Long noOfLogLinesToRead) throws IOException {

		try (BufferedReader reader = Files.newBufferedReader(Paths.get("/home/masayyed/trino-server-412/data/var/log/server.log"))) {
			DalLogDto logs = new DalLogDto();
			logs.setLogs(readAndGetLogLines(noOfLogLinesToRead, reader));
			
			return logs;

		}
	}

	private List<String> readAndGetLogLines(Long noOfLogLinesToRead, BufferedReader reader) {
		logger.info("Started Reading Logs of {} lines from log file", noOfLogLinesToRead);
		return reader.lines().limit(getNumberOfLogLinesToRead(noOfLogLinesToRead)).map(String::valueOf)
				.collect(Collectors.toList());
	}

	private long getNumberOfLogLinesToRead(Long noOfLogLinesToRead) {
		return null != noOfLogLinesToRead ? noOfLogLinesToRead : defaultNoOfLogLines;
	}
}
