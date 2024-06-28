package site.toeicdoit.tx.domain.model;


import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "users")
@ToString(exclude = {"id"})
public class UserModel extends BaseEntity {
    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String profile;
    private String name;
    private String phone;


    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<CalendarModel> calendarIds;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<PaymentModel> paymentIds;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<SubscribeModel> subscribeIds;


}
