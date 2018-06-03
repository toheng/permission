package com.hengo.beans;

import lombok.*;

import java.util.Set;

/**
 * @author Hengo.
 * @since 2018/6/2 18:32
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    private String subject;

    private String message;

    private Set<String> receivers;

}
