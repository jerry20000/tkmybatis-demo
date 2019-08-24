package cn.sisyphe.demo.core.base.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Description:
 * Date: 2019/04/21
 *
 * @author Jerry
 * @version 1.0
 */
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2985530894466446816L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
