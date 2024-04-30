package com.sky.fileuploadboard.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name= "t_file")
public class BoardFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;

	private String creatorId;
	private LocalDateTime createdDatetime;
	private String updatorId;
	private LocalDateTime updatedDatetime;

	@Column(columnDefinition = "varchar(2) default 'N'")
	private String deletedYn;

}
