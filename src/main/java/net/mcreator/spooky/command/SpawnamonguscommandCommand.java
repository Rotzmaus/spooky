
package net.mcreator.spooky.command;

@Mod.EventBusSubscriber
public class SpawnamonguscommandCommand {

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("amongus")

				.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(SpawnamonguscommandCommand::execute))
				.executes(SpawnamonguscommandCommand::execute));
	}

	private static int execute(CommandContext<CommandSourceStack> ctx) {
		ServerLevel world = ctx.getSource().getLevel();

		double x = ctx.getSource().getPosition().x();
		double y = ctx.getSource().getPosition().y();
		double z = ctx.getSource().getPosition().z();

		Entity entity = ctx.getSource().getEntity();
		if (entity == null)
			entity = FakePlayerFactory.getMinecraft(world);

		HashMap<String, String> cmdparams = new HashMap<>();
		int[] index = {-1};
		Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
			if (index[0] >= 0)
				cmdparams.put(Integer.toString(index[0]), param);
			index[0]++;
		});

		SpawnamonguscommandCommandExecutedProcedure.execute(world, x, y, z);

		return 0;
	}

}
