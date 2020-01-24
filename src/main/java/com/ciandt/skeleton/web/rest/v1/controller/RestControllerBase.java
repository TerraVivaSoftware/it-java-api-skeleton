package com.ciandt.skeleton.web.rest.v1.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Base rest controller. Defines the base path and the media type.
 *
 * @author mvidolin
 * @since Jul 31, 2019
 */
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
class RestControllerBase {

}
