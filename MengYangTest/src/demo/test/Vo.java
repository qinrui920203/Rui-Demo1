package demo.test;

import java.util.List;

public class Vo {
    private String name;
    private Integer showorder;
    private String code;
    private List<Vo> vos;
}

select
      st_number, st_name,  avg
from
      student st
       left join
         (SELECT AVG(SC_SCORE) FROM SCORE WHERE C_SCORE<60 GROUP BY SC_NUMBER) tmp
       on tmp.st_number = st. st_number
order by avg desc
