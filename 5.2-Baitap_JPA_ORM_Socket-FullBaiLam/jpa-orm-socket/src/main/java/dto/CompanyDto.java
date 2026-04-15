package dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class CompanyDto implements Serializable {

    private String id;
    private String name;
    private String industry;

}