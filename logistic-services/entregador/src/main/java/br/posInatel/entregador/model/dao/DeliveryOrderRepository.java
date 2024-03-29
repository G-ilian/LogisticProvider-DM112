package br.posInatel.entregador.model.dao;

import br.posInatel.entregador.model.DeliveryOrder;
import br.posInatel.entregador.model.entities.DeliveryOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrderEntity,Integer> {
    @Transactional(readOnly = true)
    List<DeliveryOrderEntity> findByStatus(int status);
}
