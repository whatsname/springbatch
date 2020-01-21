package com.example.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**  @author Game <game11122538@gmail.com> **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "FT_PROPERTY_CONFIG")
public class FtPropertyConfig implements Serializable {
	
	private static final long serialVersionUID = -759421175979009465L;

	@Id
    @Column(name = "CONFIG_KEY")
    private String configKey;

    @Column(name = "CONFIG_VALUE")
    private String configValue;

    @Column(name = "CONFIG_STATUS")
    private String configStatus;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

}
