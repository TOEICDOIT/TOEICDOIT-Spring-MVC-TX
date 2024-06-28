package site.toeicdoit.tx.service;


import site.toeicdoit.tx.domain.model.MessengerVo;

public interface CommandService<T> {
    MessengerVo save(T t);
    MessengerVo deleteById(Long id);
    MessengerVo modify(T t);
}
