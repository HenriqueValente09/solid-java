package br.com.alura.rh.model;

public enum Position {

	ASSISTANT {
		@Override
		public Position getNextPosition() {
			return ANALYST;
		}
	},
	ANALYST {
		@Override
		public Position getNextPosition() {
			return SPECIALIST;
		}
	},
	SPECIALIST {
		@Override
		public Position getNextPosition() {
			return MANAGER;
		}
	},
	MANAGER {
		@Override
		public Position getNextPosition() {
			return MANAGER;
		}
	};

	public abstract Position getNextPosition();
}
