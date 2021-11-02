package entidadesGraficas;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimationController {
	private ScheduledExecutorService animationSchedule;
    private AnimacionMovimiento animation;

	public AnimationController() {
    	animationSchedule = Executors.newScheduledThreadPool(1);
    }
    
	public void setAnimationSchedule(ScheduledExecutorService animationSchedule) {
		this.animationSchedule = animationSchedule;
	}

	public AnimacionMovimiento getAnimation() {
		return animation;
	}
	
    public void addMovement(AnimacionMovimiento animation) {
        animationSchedule.scheduleAtFixedRate(() -> {
			try {
				animation.animate();
				this.animation = animation;
			} catch (Exception e) {
				animationSchedule = Executors.newScheduledThreadPool(0);
			}
		}, 0, 250, TimeUnit.MILLISECONDS);
    }

}
