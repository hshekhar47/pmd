package org.hshekhar.pmd.api.controller.graph;

import java.util.List;
import java.util.Optional;

import org.hshekhar.pmd.api.controller.BaseController;
import org.hshekhar.pmd.api.model.PMDResponse;
import org.hshekhar.pmd.graph.model.version.Version;
import org.hshekhar.pmd.graph.service.VersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/graph/version")
public class VersionController extends BaseController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(VersionController.class);

    private VersionService versionService;

    public VersionController(VersionService versionService)
    {
        this.versionService = versionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<PMDResponse<Version>> create(@RequestBody Version version)
    {
        LOGGER.debug("Entry: create({})", version);
        Version savedVersion = versionService.save(version);
        LOGGER.debug("Exit: create(): {}", savedVersion);

        return createdResponse(version);
    }

    @GetMapping
    public HttpEntity<PMDResponse<List<Version>>> getAll(
            @RequestParam(value = "p", defaultValue = "0") int pageIndex,
            @RequestParam(value = "s", defaultValue = "10") int pageRecordSize)
    {
        LOGGER.debug("Entry: getAll({}, {})", pageIndex, pageRecordSize);
        ResponseEntity<PMDResponse<List<Version>>> responseEntity
                = ResponseEntity
                .status(OK)
                .body(new PMDResponse<>(versionService.find(pageIndex, pageRecordSize)));
        LOGGER.debug("Exit: getAll() : {}", responseEntity);

        return responseEntity;
    }

    @GetMapping("/{id:^[0-9]+$}")
    public HttpEntity<PMDResponse<Version>> getOneById(
            @PathVariable("version") String version,
            @PathVariable("id") Long id
    )
    {
        LOGGER.debug("Entry: getOneById({}, {})", version, id);
        ResponseEntity<PMDResponse<Version>> responseEntity = null;
        Optional<Version> oVersion = versionService.findOneById(id);
        if(oVersion.isPresent())
        {
            responseEntity = ResponseEntity
                    .status(OK)
                    .body(new PMDResponse<>(oVersion.get()));

        }
        else
        {
            responseEntity = errorResponse(NOT_FOUND, String.format("Product with id %s NOT FOUND.", id));
        }
        LOGGER.debug("Exit: getOneById() : {}", responseEntity);

        return responseEntity;
    }
}
