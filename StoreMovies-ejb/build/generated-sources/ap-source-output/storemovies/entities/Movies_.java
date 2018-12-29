package storemovies.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-16T21:13:58")
@StaticMetamodel(Movies.class)
public class Movies_ { 

    public static volatile SingularAttribute<Movies, String> mStory;
    public static volatile SingularAttribute<Movies, BigDecimal> mPrice;
    public static volatile SingularAttribute<Movies, String> mYear;
    public static volatile SingularAttribute<Movies, String> mCast;
    public static volatile SingularAttribute<Movies, Long> mId;
    public static volatile SingularAttribute<Movies, String> mTitle;
    public static volatile SingularAttribute<Movies, String> mCategory;
    public static volatile SingularAttribute<Movies, String> mDirector;

}