package site.toeicdoit.tx.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.toeicdoit.tx.domain.model.MessengerVo;
import site.toeicdoit.tx.domain.dto.ProductDto;
import site.toeicdoit.tx.repository.ProductRepository;
import site.toeicdoit.tx.service.ProductService;


@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public MessengerVo payment(ProductDto dto) {
        productRepository.save(dtoToEntity(dto));
        return MessengerVo.builder()
                .message("상품결제 성공")
                .build();
    }
}
