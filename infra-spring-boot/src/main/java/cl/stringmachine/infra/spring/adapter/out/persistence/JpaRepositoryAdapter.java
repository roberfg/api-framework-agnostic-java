package cl.stringmachine.infra.spring.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositoryAdapter extends JpaRepository<CardEntity, Long> {
}
