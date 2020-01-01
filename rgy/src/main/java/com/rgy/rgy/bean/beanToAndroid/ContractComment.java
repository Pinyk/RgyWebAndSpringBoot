package com.rgy.rgy.bean.beanToAndroid;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "contract_comment")
public class ContractComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentId;

    //合同编号
    @Column
    private String commentContent;

    @Column
    private String commentTime;

    @Column
    private Integer contractId;

    @Column
    private Integer userId;

}
