package com.DraftThreeCRUD.DraftThree.Repository;

import com.DraftThreeCRUD.DraftThree.Model.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepo extends JpaRepository<Flower,Long> {
}
