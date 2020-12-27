package jpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group extends BaseIdentify{

   public final static boolean OPEN = true;
   public final static boolean CLOSE = false;

   public Group() {
   }

   public Group(Mountain mountain, boolean isRecruiting, LocalDate dateOfClimbing, LocalTime durationOfClimbing) {
      this.mountain = mountain;
      this.isRecruiting = isRecruiting;
      this.dateOfClimbing = dateOfClimbing;
      this.durationOfClimbing = durationOfClimbing;
   }


   @OneToOne
   private Mountain mountain;

   @Column(nullable = false)
   private boolean isRecruiting;

   @Column(nullable = false)
   private LocalDate dateOfClimbing;

   @Column(nullable = false)
   private LocalTime durationOfClimbing;

   @OneToMany(cascade = CascadeType.ALL)
   @JoinTable(name = "groups_climbers",
           joinColumns = @JoinColumn(name = "groups_id"),
           inverseJoinColumns = @JoinColumn(name = "climbers_id"))
   private List<Climber> climbers = new ArrayList<Climber>();

   public void addClimber(Climber climber){
      climbers.add(climber);
   }

   public void setStatus(boolean isRecruiting){
      this.isRecruiting = isRecruiting;
   }

   @Override
   public String toString() {
      return "Group{" +
              "mountain=" + mountain +
              ", isRecruiting=" + isRecruiting +
              ", dateOfClimbing=" + dateOfClimbing +
              ", durationOfClimbing=" + durationOfClimbing +
              ", climbers=" + climbers +
              '}';
   }
}
