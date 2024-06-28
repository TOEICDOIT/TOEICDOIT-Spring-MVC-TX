package site.toeicdoit.tx.service;

import site.toeicdoit.tx.domain.model.MessengerVo;

import java.util.List;
import java.util.Optional;

public interface QueryService <T>{
    List<T> findAll();
    Optional<T> findById(Long id);
    MessengerVo count();
    Boolean existsById(Long id);
}