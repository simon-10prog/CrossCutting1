package co.edu.uco.ucobet.domain;

import java.util.UUID;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.crosscutting.helpers.TextHelper;
import co.edu.uco.crosscutting.helpers.UUIDHelper;

public class CityDomain extends Domain {

	private String name;
	private static StateDomain state;
	
	private CityDomain (final UUID id, final String name, final StateDomain State) {
		super(id);
		setName(name);
		setState(State);
		
	}	
	
	public static final CityDomain create (final UUID id, final String name, final StateDomain State) {
		return new CityDomain(id, name, state);
	}
	
	static final CityDomain create () {
		return new CityDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, StateDomain.create());
	}
	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	@Override
	public UUID getId() {
		return super.getId();
	}

	protected StateDomain getState() {
		return state;
	}

	private void setState(final StateDomain state) {
		CityDomain.state = ObjectHelper.getDefault(state, StateDomain.create());
	}
	
	
	
}
