package com.dal.log.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dal.log.dto.DalLogDto;
import com.dal.log.service.DalReadLogsService;

@RestController
public class DalReadLogsController {

	@Autowired
	private DalReadLogsService logsService;

	@CrossOrigin
	@GetMapping(value = "/logs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DalLogDto> getLogs(@RequestParam(value = "log-lines", required = false) Long logLinse)
			throws IOException {

		return ResponseEntity.ok().body(logsService.getLogs(logLinse));

	}

}
