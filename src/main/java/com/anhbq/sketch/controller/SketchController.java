package com.anhbq.sketch.controller;

import com.anhbq.sketch.model.*;
import com.anhbq.sketch.service.SketchService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/sketch")
@AllArgsConstructor
public class SketchController {
    private final SketchService sketchService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<SketchRest> result = this.sketchService.getAllSketch();
            return new ResponseEntity<List<SketchRest>>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/paging")
    public ResponseEntity<?> getAll(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size
    ) {
        try {
            Page<SketchRest> result = this.sketchService.getAllSketch(page, size);
            return new ResponseEntity<Page<SketchRest>>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchForSketch(@RequestParam(name = "name") String name) {
        try {
            List<SketchRest> result = this.sketchService.findSketchesContaining(name);
            return new ResponseEntity<List<SketchRest>>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/search/paging")
    public ResponseEntity<?> searchForSketch(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size
    ) {
        try {
            Page<SketchRest> result = this.sketchService.findSketchesContaining(name, page, size);

            return new ResponseEntity<Page<SketchRest>>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSketch(@PathVariable("id") Long id) {
        try {
            SketchRest result = this.sketchService.getSketchById(id);
            return new ResponseEntity<SketchRest>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveSketch(@RequestBody SketchRest request) {
        try {
            SketchRest result = this.sketchService.saveSketch(request);
            return new ResponseEntity<SketchRest>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateSketch(@RequestBody SketchRest request) {
        try {
            SketchRest result = this.sketchService.updateSketch(request);
            return new ResponseEntity<SketchRest>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/name")
    public ResponseEntity<?> updateSketchName(@RequestBody SketchUpdateNameRequest request) {
        try {
            SketchRest result = this.sketchService.updateSketchName(request.getId(), request.getName());
            return new ResponseEntity<SketchRest>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/image")
    public ResponseEntity<?> updateSketchImageURL(@RequestBody SketchUpdateImageRequest request) {
        try {
            SketchRest result = this.sketchService.updateImageURL(request.getId(), request.getImageURL());
            return new ResponseEntity<SketchRest>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/background")
    public ResponseEntity<?> updateSketchBackground(@RequestBody SketchUpdateBackgroundRequest request) {
        try {
            SketchRest result = this.sketchService.updateSketchBackground(request.getId(), request.getBackground());
            return new ResponseEntity<SketchRest>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/size")
    public ResponseEntity<?> updateSketchSize(@RequestBody SketchUpdateSizeRequest request) {
        try {
            SketchRest result = this.sketchService.updateSketchSize(request.getId(), request.getWidth(), request.getHeight());
            return new ResponseEntity<SketchRest>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteSketch(@PathVariable("id") Long id) {
        try {
            SketchRest result = this.sketchService.deleteSketch(id);
            return new ResponseEntity<SketchRest>(result, HttpStatus.OK);
        }
        catch (Exception e) {
            ExceptionResponse response = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
