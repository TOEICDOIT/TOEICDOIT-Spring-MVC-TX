package site.toeicdoit.tx.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.toeicdoit.tx.domain.model.MessengerVo;
import site.toeicdoit.tx.domain.dto.SubscribeDto;
import site.toeicdoit.tx.service.Impl.SubscribeServiceImpl;


@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/subscribe")
@RequiredArgsConstructor
public class SubscribeController {
    private final SubscribeServiceImpl subscribeService;

    @PostMapping("/save")
    public ResponseEntity<MessengerVo> save(@RequestBody SubscribeDto dto)  {
        log.info("입력받은 정보: {}",dto);
        return ResponseEntity.ok(subscribeService.save(dto));
    }

    @PostMapping("/check")
    public ResponseEntity<MessengerVo> check(@RequestBody Long userId)  {
        log.info("입력받은 정보: {}",userId);
        return ResponseEntity.ok(subscribeService.check(userId));
    }
}
